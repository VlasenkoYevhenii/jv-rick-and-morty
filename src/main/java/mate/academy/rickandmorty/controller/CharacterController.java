package mate.academy.rickandmorty.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.rickandmorty.dto.CharacterDto;
import mate.academy.rickandmorty.dto.ResponseDto;
import mate.academy.rickandmorty.service.CharacterService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/characters")
public class CharacterController {
    private final CharacterService service;

    @GetMapping("/by-name")
    public List<ResponseDto> getCharactersByName(@RequestParam String name, Pageable pageable) {
        return service.getCharactersByName(name, pageable);
    }

    @GetMapping("/random")
    public CharacterDto getRandomCharacter(@PathVariable Long id) {
        return service.getRandomCharacter();
    }
}
