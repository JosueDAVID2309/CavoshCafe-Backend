package com.senati.cavosh_cafe.infrastructure.persistence.repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.senati.cavosh_cafe.domain.entity.Usuario;
import com.senati.cavosh_cafe.domain.repository.UsuarioRepository;

@Repository
public class JdbcUsuarioRepository implements UsuarioRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcUsuarioRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<Usuario> buscarPorCorreo(String correo) {

        String sql = "SELECT id, nombre_completo, correo, contrasena FROM Usuario WHERE correo = ?";

        try {
            Usuario usuario = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
                Usuario u = new Usuario();
                u.setId(rs.getLong("id"));
                u.setNombre_completo(rs.getString("nombre_completo"));
                u.setCorreo(rs.getString("correo"));
                u.setContrasena(rs.getString("contrasena"));
                return u;
            }, correo);

            return Optional.of(usuario);

        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Long registrarUsuario(Usuario usuario) {
        String sql = """
                INSERT INTO Usuario(nombre_completo, correo, contrasena)
                VALUES (?, ?, ?)
                """;

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, usuario.getNombre_completo());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, usuario.getContrasena());

            return ps;
        }, keyHolder);

        return keyHolder.getKey().longValue();
    }

    @Override
    public boolean existePorCorreo(String correo) {

        String sql = "SELECT EXISTS(SELECT 1 FROM Usuario WHERE correo = ?)";

        return jdbcTemplate.queryForObject(sql, Boolean.class,
                correo);
    }
}
