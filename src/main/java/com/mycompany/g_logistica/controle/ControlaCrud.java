/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.g_logistica.controle;

import com.mycompany.g_logistica.modelo.Rota;
import com.mycompany.g_logistica.modelo.RotaJpaController;
import com.mycompany.g_logistica.modelo.Transportador;
import com.mycompany.g_logistica.modelo.TransportadorJpaController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author hexp_
 */
@Controller
public class ControlaCrud {
    
    @RequestMapping(value = "/cadastrarRota.htm", method = RequestMethod.POST)
    public String cadastrarRota(Model model, Transportador transportador){
        new TransportadorJpaController().create(transportador);
        model.addAttribute("msg", "Rota cadastrada com sucesso!!!");
        return "info/sucesso";
    }
    
    @RequestMapping(value = "/incluirCarga.htm", method = RequestMethod.POST)
    public String incluirCarga(Model model, Rota rota){
        new RotaJpaController().create(rota);
        model.addAttribute("msg", "Carga incluida com sucesso!!!");
        return "info/sucesso";
    }
}
