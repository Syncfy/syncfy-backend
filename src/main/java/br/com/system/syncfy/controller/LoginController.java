package br.com.system.syncfy.controller;

import br.com.system.syncfy.model.entity.Usuario;
import br.com.system.syncfy.model.repository.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final UsuarioRepository usuarioRepository;

    public LoginController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public String login() {
        return "login";
    }

    @PostMapping
    public String fazerLogin(@RequestParam String nome, @RequestParam String senha, HttpSession session, Model model) {
        Optional<Usuario> usuarioOptional = Optional.ofNullable(usuarioRepository.findByNomeAndSenha(nome, senha));
        if (usuarioOptional.isPresent()) {
            session.setAttribute("usuarioLogado", nome);
            Long idUsuarioLogado = usuarioOptional.get().getCodUser();
            System.out.println("ID do usuário logado: " + idUsuarioLogado);
            model.addAttribute("idUsuarioLogado", idUsuarioLogado.toString());
            return "redirect:/";
        } else {
            model.addAttribute("mensagemErro", "Nome de usuário ou senha incorretos");
            return "login";
        }

    }

}
