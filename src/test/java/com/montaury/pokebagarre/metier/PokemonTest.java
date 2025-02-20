package com.montaury.pokebagarre.metier;

import org.junit.jupiter.api.Test;

import static com.montaury.pokebagarre.fixtures.ConstructeurDePokemon.unPokemon;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PokemonTest {
    /*
    • Le Pokémon qui a la meilleure attaque remporte la bagarre,
    • Si les 2 Pokémon ont la même attaque, celui qui a la meilleure défense remporte la bagarre,
    • Si les 2 Pokémon ont la même attaque et la même défense, le premier renseigné par l’utilisateur a la
    priorité et remporte la bagarre.
     */
    @Test
    void devrait_etre_vainqueur_s_il_a_une_meilleure_attaque(){
        //Given
        Pokemon pokemon1 = new Pokemon("pokemon1", "", new Stats(150,100));
        Pokemon pokemon2 = new Pokemon("pokemon2", "", new Stats(140,100));

        //When
        boolean estVainqueur = pokemon1.estVainqueurContre(pokemon2);

        //Then
        assertThat(estVainqueur).isTrue();
    }

    @Test
    void devrait_etre_perdant_s_il_a_une_moins_bonne_attaque(){
        //Given
        Pokemon pokemon1 = unPokemon().avecAttaque(140).construire();
        Pokemon pokemon2 = unPokemon().avecAttaque(150).construire();

        //When
        boolean estVainqueur = pokemon1.estVainqueurContre(pokemon2);

        //Then
        assertThat(estVainqueur).isFalse();
    }

    @Test
    void devrait_etre_gagnant_s_il_a_une_meilleure_defense(){
        //Given
        Pokemon pokemon1 = unPokemon().avecDefense(100).construire();
        Pokemon pokemon2 = unPokemon().avecDefense(90).construire();

        //When
        boolean estVainqueur = pokemon1.estVainqueurContre(pokemon2);

        //Then
        assertThat(estVainqueur).isTrue();
    }

    @Test
    void devrait_etre_perdant_s_il_a_une_moins_bonne_defense(){
        //Given
        Pokemon pokemon1 = unPokemon().avecDefense(90).construire();
        Pokemon pokemon2 = unPokemon().avecDefense(100).construire();

        //When
        boolean estVainqueur = pokemon1.estVainqueurContre(pokemon2);

        //Then
        assertThat(estVainqueur).isFalse();
    }

    @Test
    void devrait_etre_gagnant_si_les_attaques_et_defenses_sont_identiques(){
        //Given
        Pokemon pokemon1 = unPokemon().avecAttaque(150).avecDefense(100).construire();
        Pokemon pokemon2 = unPokemon().avecAttaque(150).avecDefense(100).construire();

        //When
        boolean estVainqueur = pokemon1.estVainqueurContre(pokemon2);

        //Then
        assertThat(estVainqueur).isTrue();
    }

}