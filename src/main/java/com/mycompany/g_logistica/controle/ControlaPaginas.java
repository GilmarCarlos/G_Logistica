/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.g_logistica.controle;

import com.mycompany.g_logistica.modelo.ConsultaData;
import com.mycompany.g_logistica.modelo.RotaJpaController;
import com.mycompany.g_logistica.modelo.TransportadorJpaController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author hexp_
 */
@Controller
public class ControlaPaginas {

    @RequestMapping(value = "/index.htm", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/cadastrar-rota.htm", method = RequestMethod.GET)
    public String cadastra_rota() {
        return "rota/cadastra";
    }

    @RequestMapping(value = "/incluir-carga.htm", method = RequestMethod.GET)
    public String incluir_carga(Model model) {
        model.addAttribute("transportadores", new TransportadorJpaController().findTransportadorEntities());
        return "montagem-de-carga/incluir";
    }

    @RequestMapping(value = "/consultar-rota.htm", method = RequestMethod.GET)
    public String consulta_rota() {
        return "rota/consulta";
    }

    @RequestMapping(value = "/proximas-rotas.htm", method = RequestMethod.GET)
    public String proximas_rotas(Model model) {
        model.addAttribute("titulo", "Próximas Rotas");
        model.addAttribute("rotas", new TransportadorJpaController().findTransportadorEntities());
        return "rota/proxima";
    }

    @RequestMapping(value = "/info-rota.htm", method = RequestMethod.GET)
    public String info_rota(@RequestParam(value = "idTransportador") int idTransportador, Model model) {
        model.addAttribute("rota", new TransportadorJpaController().findTransportador(idTransportador));
        return "rota/info";
    }

    @RequestMapping(value = "/buscar-rota-por-motorista.htm", method = RequestMethod.POST)
    public String rota_por_motorista(@RequestParam(value = "motorista") String motorista, Model model) {
        model.addAttribute("titulo", "Consulta por Motorista");
        model.addAttribute("rotas", new TransportadorJpaController().findTransportadorMotorista(motorista));
        return "rota/proxima";
    }

    @RequestMapping(value = "/buscar-rota-por-veiculo.htm", method = RequestMethod.POST)
    public String rota_por_veiculo(@RequestParam(value = "veiculo") String veiculo, Model model) {
        model.addAttribute("titulo", "Consulta por Veículo");
        model.addAttribute("rotas", new TransportadorJpaController().findTransportadorVeiculo(veiculo));
        return "rota/proxima";
    }

    @RequestMapping(value = "/buscar-rota-por-transportador.htm", method = RequestMethod.POST)
    public String rota_por_transportador(@RequestParam(value = "nomeTransp") String nomeTransp, Model model) {
        model.addAttribute("titulo", "Consulta por Transportador");
        model.addAttribute("rotas", new TransportadorJpaController().findTransportadorTransportador(nomeTransp));
        return "rota/proxima";
    }
    
    @RequestMapping(value = "/buscar-rota-por-periodo.htm", method = RequestMethod.POST)
    public String rota_por_periodo(ConsultaData data, Model model) {
        model.addAttribute("titulo", "Consulta por Periodo");
        model.addAttribute("rotas", new TransportadorJpaController().findTransportadorPeriodo(data));
        return "rota/proxima";
    }
    
    @RequestMapping(value = "/ver-rota.htm", method = RequestMethod.GET)
    public String ver_rota(@RequestParam(value = "idTransportador") int idTransportador , Model model) {
        model.addAttribute("rotas", new RotaJpaController().findRotaT(idTransportador));
        return "montagem-de-carga/dados-da-carga";
    }
}
