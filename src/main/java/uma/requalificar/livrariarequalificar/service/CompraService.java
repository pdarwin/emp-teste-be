package uma.requalificar.livrariarequalificar.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uma.requalificar.livrariarequalificar.dto.ListaResposta;
import uma.requalificar.livrariarequalificar.model.Cliente;
import uma.requalificar.livrariarequalificar.model.Compra;
import uma.requalificar.livrariarequalificar.model.Cupao;
import uma.requalificar.livrariarequalificar.model.Livro;
import uma.requalificar.livrariarequalificar.repository.ClienteRepository;
import uma.requalificar.livrariarequalificar.repository.CompraRepository;
import uma.requalificar.livrariarequalificar.repository.CupaoRepository;
import uma.requalificar.livrariarequalificar.repository.LivroRepository;

@Service
public class CompraService {
	private final CompraRepository compraRepository;
	private final CupaoRepository cupaoRepository;
	private final ClienteRepository clienteRepository;
	private final LivroRepository livroRepository;

	@Autowired
	public CompraService(CompraRepository compraRepository, CupaoRepository cupaoRepository,
			ClienteRepository clienteRepository, LivroRepository livroRepository) {
		this.compraRepository = compraRepository;
		this.cupaoRepository = cupaoRepository;
		this.clienteRepository = clienteRepository;
		this.livroRepository = livroRepository;
	}

	public List<Compra> getCompras() {
		List<Compra> compras = new ArrayList<>();
		compraRepository.findAll().forEach(compras::add);

		return compras;
	}

	// Regras de Negócio

	public ListaResposta getComprasByClienteId(String cliente_id) {
		ListaResposta listaResposta = new ListaResposta();

		try {
			List<Compra> compras = new ArrayList<>();
			compraRepository.findAll().forEach(compras::add);

			List<Compra> comprasByCliente = new ArrayList<>();
			for (Compra compra : compras) {
				if (compra.getCliente().getId() == Long.parseLong(cliente_id)) {
					comprasByCliente.add(compra);
				}
			}
			listaResposta.setLista(comprasByCliente);
			return listaResposta;

		} catch (NumberFormatException e) {
			listaResposta.addMsg("Erro de formato no ID da compra");
			return listaResposta;
		}
	}

	public ListaResposta addCompra(Compra compra, String cliente_id) {
		ListaResposta listaResposta = new ListaResposta();

		if (compra.getValor() <= 0) {
			listaResposta.addMsg("O valor da compra tem de ser maior que zero.");
			return listaResposta;
		}

		if (compra.getLivros().size() == 0) {
			listaResposta.addMsg("Não existem livros associados a esta compra.");
			return listaResposta;
		}

		// Acha o cliente
		Cliente cliente = clienteRepository.findById(Long.parseLong(cliente_id)).get();

		compra.setCliente(cliente);

		// Coloca a data atual
		compra.setData(new Date(System.currentTimeMillis()));
		
		// Verifica todos os livros da compra existem em stock
		for (Livro livro : compra.getLivros()) {
			Livro livroAux = livroRepository.findById(livro.getId()).get();

			if (livroAux.getStock() - livro.getStock() < 0) {
				listaResposta.addMsg("Quantidade insuficiente em stock para o livro: " + livro.getTitulo()+ ". Por favor reduza a quantidade e volte a tentar.");
				return listaResposta;
			}
		}

		// Abate os livros em stock
		for (Livro livro : compra.getLivros()) {
			Livro livroAux = livroRepository.findById(livro.getId()).get();

				livroAux.setStock(livroAux.getStock() - livro.getStock());
				livroRepository.save(livroAux);

		}

		// Gera cupões
		if (compra.getValor() >= 50) {
			Cupao cupao = new Cupao();
			cupao.setCliente(cliente);
			int desconto = (compra.getValor() < 100) ? 5 : 15;
			cupao.setDesconto(desconto);
			cupaoRepository.save(cupao);
		}

		compraRepository.save(compra);
		listaResposta.setNewID(compra.getId());
		listaResposta.setStatusOk(true);
		return listaResposta;
	}

}
