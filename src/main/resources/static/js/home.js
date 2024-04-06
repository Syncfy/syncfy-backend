function getNomeUsuario() {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                document.getElementById("nomeUsuario").innerText =
                    "Nome do Usuário: " + xhr.responseText;
            } else {
                console.error("Erro ao obter o nome do usuário:", xhr.status);
                document.getElementById("nomeUsuario").innerText =
                    "Erro ao obter o nome do usuário.";
            }
        }
    };
    xhr.open("GET", "/api/usuario", true);
    xhr.send();
}
