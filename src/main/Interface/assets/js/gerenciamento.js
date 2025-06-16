window.onload = function() {
  buscarBibliotecarios();
  buscarLivros();
};

function buscarBibliotecarios() {
  fetch("http://localhost:8080/api/bibliotecario")
    .then(res => res.json())
    .then(dados => {
      const select = document.getElementById("bibliotecario");
      dados.forEach(b => {
        const option = document.createElement("option");
        option.value = b.id;
        option.textContent = b.nome;
        select.appendChild(option);
      });
    });
}

function buscarLivros() {
  fetch("http://localhost:8080/api/livros")
    .then(res => res.json())
    .then(lista => {
      const tabela = document.getElementById("tabelaCorpo");
      tabela.innerHTML = "";
      lista.forEach(livro => {
        const linha = document.createElement("tr");
        linha.innerHTML = `
          <td class="px-4 py-2">${livro.id}</td>
          <td class="px-4 py-2">${livro.titulo}</td>
          <td class="px-4 py-2">${livro.autor}</td>
          <td class="px-4 py-2">${livro.genero}</td>
          <td class="px-4 py-2">${livro.status}</td>
          <td class="px-4 py-2">${livro.bibliotecario.nome}</td>
          <td class="px-4 py-2">
            <button class="bg-yellow-400 text-white px-2 py-1 rounded" onclick="editar(this)">Editar</button>
            <button class="bg-red-500 text-white px-2 py-1 rounded" onclick="remover(this)">Remover</button>
          </td>
        `;
        tabela.appendChild(linha);
      });
    });
}

function cadastrar() {
  event.preventDefault();

  const titulo = document.getElementById("titulo").value;
  const autor = document.getElementById("autor").value;
  const genero = document.getElementById("genero").value;
  const status = document.getElementById("status").value;
  const idBibliotecario = document.getElementById("bibliotecario").value;

  const novoLivro = {
    titulo, autor, genero, status,
    bibliotecario: { id: Number(idBibliotecario) }
  };

  fetch("http://localhost:8080/api/livros", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(novoLivro)
  })
  .then(res => res.json())
  .then(() => {
    buscarLivros();
    document.getElementById("formCadastro").reset();
    alert("Livro cadastrado com sucesso!");
  });
}

function remover(botao) {
  const linha = botao.closest("tr");
  const id = linha.children[0].innerText;

  fetch(`http://localhost:8080/api/livros/${id}`, {
    method: "DELETE"
  })
  .then(() => {
    buscarLivros();
    alert("Livro removido com sucesso!");
  });
}

function editar(botao) {
  const linha = botao.closest("tr");
  const id = linha.children[0].innerText;

  const novoTitulo = prompt("Novo título:", linha.children[1].innerText);
  const novoAutor = prompt("Novo autor:", linha.children[2].innerText);
  const novoGenero = prompt("Novo gênero:", linha.children[3].innerText);
  const novoStatus = prompt("Novo status:", linha.children[4].innerText);

  if (!novoTitulo || !novoAutor || !novoGenero || !novoStatus) {
    alert("Todos os campos devem ser preenchidos.");
    return;
  }

  const livroAtualizado = {
    titulo: novoTitulo,
    autor: novoAutor,
    genero: novoGenero,
    status: novoStatus
  };

  fetch(`http://localhost:8080/api/livros/${id}`, {
    method: "PUT",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(livroAtualizado)
  })
  .then(() => {
    buscarLivros();
    alert("Livro atualizado com sucesso!");
  });
}
