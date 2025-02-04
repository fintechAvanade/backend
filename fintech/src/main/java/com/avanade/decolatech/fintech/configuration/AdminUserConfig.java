package com.avanade.decolatech.fintech.configuration;

import com.avanade.decolatech.fintech.models.entities.Endereco;
import com.avanade.decolatech.fintech.models.entities.Usuario;
import com.avanade.decolatech.fintech.models.enums.TipoUsuario;
import com.avanade.decolatech.fintech.models.repositories.EnderecoRepository;
import com.avanade.decolatech.fintech.models.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Configuration
public class AdminUserConfig implements CommandLineRunner {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        var userAdmin = usuarioRepository.findByNomeUsuario("admin");

        if(userAdmin!=null){
            System.out.println("admin já está cadastrado");
        }

        else {
            var endereco = new Endereco();
            endereco.setCep("01001000");
            endereco.setLogradouro("Praça da Sé");
            endereco.setComplemento("lado ímpar");
            endereco.setBairro("Sé");
            endereco.setCidade("São Paulo");
            endereco.setEstado("SP");
            endereco.setNumero(1);
            enderecoRepository.save(endereco);
            var user = new Usuario();
            user.setNome("admin");
            user.setCpf("52418290085");
            try {
                user.setDataNascimento(new SimpleDateFormat("yyyy-MM-dd").parse("2003-08-20"));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            user.setEmail("admin@email.com");
            user.setTelefone("40028922");
            user.setNomeUsuario("admin");
            user.setTipoUsuario(TipoUsuario.ADMIN);
            user.setNumerosTentativasAcesso(0);
            user.setAtivo(true);
            user.setEndereco(endereco);
            user.setHashSenha(passwordEncoder.encode("123"));
            usuarioRepository.save(user);
        }
    }
}