package pl.mg.projects.players.entities;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teamName;

    @OneToMany(mappedBy = "team", cascade = CascadeType.PERSIST)
    @MapKey(name = "name")
    private Map<String, Player> players;

    public Team() {
        players = new HashMap<String, Player>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void addPlayer(Player player) {
        if (!getPlayers().containsKey(player.getName())) {
            getPlayers().put(player.getName(), player);
            if (player.getTeam() != null) {
                player.getTeam().getPlayers().remove(player.getName());
            }
            player.setTeam(this);
        }
    }

    public Map<String, Player> getPlayers() { return players; }
}
