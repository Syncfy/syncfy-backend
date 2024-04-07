document.addEventListener("DOMContentLoaded", function () {
    const idUsuarioLogado = 1;
    console.log('ID do usuário recuperado:', idUsuarioLogado);

    if (idUsuarioLogado) {
        fetch(`/company/${idUsuarioLogado}`)
            .then(response => response.json())
            .then(data => preencherDadosUsuario(data))
            .catch(error => console.error('Erro ao obter dados:', error));
    } else {
        console.error('ID do usuário não encontrado no Local Storage.');
    }

    document.getElementById("deleteButton").addEventListener("click", function () {
        if (confirm("Tem certeza que deseja excluir seu perfil?")) {
            fetch(`/company/${idUsuarioLogado}`, {
                method: 'DELETE'
            })
                .then(response => {
                    if (response.ok) {
                        window.location.href = 'http://localhost:8080';
                    } else {
                        alert("Erro ao excluir perfil. Por favor, tente novamente mais tarde.");
                    }
                })
                .catch(error => console.error('Erro ao excluir perfil:', error));
        }
    });

});

function preencherDadosUsuario(data) {
    console.log(data);
    document.querySelector('input[name="usuario.nome"]').value = data.usuario.usuario;
    document.querySelector('input[name="email"]').value = data.email;
    document.querySelector('input[name="cnpj"]').value = data.cnpj;
    document.querySelector('input[name="tipo"]').value = data.tipo;
    document.querySelector('input[name="segmento.nome"]').value = data.segmento.nome;
    document.querySelector('input[name="nome"]').value = data.nome;
}
