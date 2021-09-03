package com.example.controllers;

import com.example.models.Imovel;
import com.example.models.Quartos;
import com.example.service.ImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/imovel")
@RestController
public class ImovelController {

    @Autowired
    private ImovelService imovelService;

    @PostMapping(value = "criar")
    public Imovel criar(@RequestBody Imovel imovel){
        ImovelService.criar(imovel);
        return imovel;
    }

    @GetMapping(value = "/area/{nome}")
    public Double retornarMetroTotImovel(@PathVariable String nome){
        return ImovelService.retornaMetrosImovel(nome);
    }

    @GetMapping(value = "valor/{nome}")
    public Double valorImovel(@PathVariable String nome){
        return ImovelService.valorImovel(nome);
    }

    @GetMapping(value = "/areaQuarto/{nome}")
    public Quartos maiorQuarto(@PathVariable String nome) {
        return ImovelService.maiorQuarto(nome);
    }

    @GetMapping(value = "areaPorQuarto/{nome}")
    public String areaPorQuarto(@PathVariable String nome) {
        return ImovelService.areaPorQuarto(nome);
    }


}

