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

    document.getElementById("saveButton").addEventListener("click", function () {
        const senha = document.getElementById("senha").value;
        if (senha.trim() === "") {
            alert("Por favor, coloque sua senha.");
            return;
        }

        const dadosAtualizados = {
            codPessoa: idUsuarioLogado,
            cnpj: document.getElementById("cnpj").value,
            email: document.getElementById("email").value,
            usuario: {
                codUser: idUsuarioLogado,
                nome: document.getElementById("usuario_nome").value,
                senha: senha
            },
            nome: document.getElementById("nome").value,
            tipo: document.getElementById("tipo").value,
            segmento: {
                codSegmento: 1,
                nome: document.getElementById("segmento_nome").value
            }
        };

        fetch(`/company/${idUsuarioLogado}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(dadosAtualizados)
        })
            .then(response => {
                if (response.ok) {
                    alert("Perfil atualizado com sucesso!");
                } else {
                    alert("Erro ao atualizar perfil. Por favor, tente novamente mais tarde.");
                }
            })
            .catch(error => console.error('Erro ao atualizar perfil:', error));
    });
});

function preencherDadosUsuario(data) {
    console.log(data);
    document.getElementById("usuario_nome").value = data.usuario.usuario;
    document.getElementById("email").value = data.email;
    document.getElementById("cnpj").value = data.cnpj;
    document.getElementById("tipo").value = data.tipo;
    document.getElementById("segmento_nome").value = data.segmento.nome;
    document.getElementById("nome").value = data.nome;
}
