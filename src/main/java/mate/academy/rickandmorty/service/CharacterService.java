package mate.academy.rickandmorty.service;

import mate.academy.rickandmorty.dto.CharacterDto;
import mate.academy.rickandmorty.model.Character;

import java.util.List;

public interface CharacterService {
    List<CharacterDto> getCharactersByName(String name);

    CharacterDto getRandomCharacter();
}
