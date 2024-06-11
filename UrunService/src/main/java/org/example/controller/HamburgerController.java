package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.entity.enums.ECikartilacakUrunMalzemeleri;
import org.example.entity.enums.EExtraMalzeme;
import org.example.entity.enums.EPismeDerecesi;
import org.example.entity.enums.ESos;
import org.example.service.HamburgerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

import static org.example.constants.EndPoints.*;

@RestController
@RequestMapping(HAMBURGER)
@RequiredArgsConstructor
public class HamburgerController
{
    private final HamburgerService hamburgerService;

    @PostMapping(SAVE)
    public ResponseEntity<String> save(@RequestParam Set<ECikartilacakUrunMalzemeleri> cikarilacakMalzemeler, @RequestParam Set<EExtraMalzeme> ekstraMalzemeler, @RequestParam EPismeDerecesi pismeDerecesi, @RequestParam Set<ESos> soslar, @RequestParam Double hamburgerBirimFiyati, @RequestParam String ad)
    {
        return ResponseEntity.ok(hamburgerService.save(cikarilacakMalzemeler, ekstraMalzemeler, pismeDerecesi,soslar, hamburgerBirimFiyati, ad));
    }

}