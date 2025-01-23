package fr.eni.tp.petitschats.dal;

import fr.eni.tp.petitschats.bo.Chat;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoChatSQLImpl implements DaoChat {
    static final String SELECT_ALL = "select * from chat";
    static final String SELECT_BY_ID = "select * from chat where id=?";
    static final String INSERT = "INSERT  INTO Chat ([name],[color]) VALUES (?,?)";
    static final String DELETE = "DELETE FROM Chat where id=?";
    static final String UPDATE = "UPDATE Chat set name=?,color=? where id=?";

    JdbcTemplate jdbcTemplate;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public DaoChatSQLImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Chat> read() {
        return jdbcTemplate.query(SELECT_ALL, BeanPropertyRowMapper.newInstance(Chat.class));
    }

    @Override
    public Chat read(int id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID, BeanPropertyRowMapper.newInstance(Chat.class), id);
    }

//    @Override
//    public int create(Chat chat) {
//        return jdbcTemplate.update(INSERT, chat.getName(), chat.getColor());
//    }

    @Override
    public int create(Chat chat) {
        var namedparameters = new MapSqlParameterSource();
        namedparameters.addValue("name", chat.getName());
        namedparameters.addValue("color", chat.getColor());
        var keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update("INSERT  INTO Chat ([name],[color]) VALUES (:name,:color)", namedparameters, keyHolder);
        return keyHolder.getKey().intValue();
    }


    @Override
    public void update(Chat chat) {
        jdbcTemplate.update(UPDATE, chat.getName(), chat.getColor(), chat.getId());
    }

    @Override
    public void delete(Chat chat) {
        delete(chat.getId());
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(DELETE, id);
    }
}
