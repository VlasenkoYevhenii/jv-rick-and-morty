package mate.academy.rickandmorty.service;

import lombok.RequiredArgsConstructor;
import mate.academy.rickandmorty.dto.CharacterDto;
import mate.academy.rickandmorty.exception.EntityNotFoundException;
import mate.academy.rickandmorty.mapper.CharacterMapper;
import mate.academy.rickandmorty.repository.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CharacterServiceImpl implements CharacterService{
    private final Random random = new Random();
    private final CharacterRepository repository;
    private final CharacterMapper mapper;

    @Override
    public List<CharacterDto> getCharactersByName(String name) {
        return repository.findAllByNameContainingIgnoreCase(name).stream()
                .map(mapper::toDto).toList();
    }

    @Override
    public CharacterDto getRandomCharacter() {
        return mapper.toDto(repository.findById(random.nextLong(countCharactersInDb()))
                .orElseThrow(() -> new EntityNotFoundException(
                        "Failed to get random Character from DB")));
    }

    private Long countCharactersInDb() {
        return repository.count();
    }
}
