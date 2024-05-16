package com.ovd.gestiondocument.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Utilisateurs")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;

    // Getters, setters et autres propriétés

    // Relation Many-to-Many avec les profils de rôles
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "utilisateur_role",
            joinColumns = @JoinColumn(name = "utilisateur_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    // Méthodes pour ajouter ou supprimer des rôles
    public void ajouterRole(Role role) {
        roles.add(role);
        role.getUtilisateurs().add(this);
    }

    public void supprimerRole(Role role) {
        roles.remove(role);
        role.getUtilisateurs().remove(this);
    }
}
