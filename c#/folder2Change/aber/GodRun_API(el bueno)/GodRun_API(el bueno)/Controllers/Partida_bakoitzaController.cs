﻿using GodRun_API_el_bueno_.Models;
using GodRun_API_el_bueno_.ViewModels;
using GodRun_API_el_bueno_.Services;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace GodRun_API_el_bueno_.Controllers
{
    public class Partida_bakoitzaController : Controller
    {
        private readonly IPartidaService _partidaService;
        public Partida_bakoitzaController(IPartidaService _partidaService)
        {
            this._partidaService = _partidaService;
        }

        // GET: HomeController
        
        /*
         public async Task<IActionResult> Index(Partida partida)
         {
             //var part = Partida.PartidakLortu(this.HttpContext);
             var partidaViewModel = new PartidaViewModel();
             partidaViewModel.partidak = new List<Partida>();
             partidaViewModel.partidak.Add(partida);
             return View(partidaViewModel);
         }
        */

        
        public async Task<IActionResult> Index(int puntuazioa, int kills, string time, string date, string izena, string jobTitle, string workPhone, string workEmail)
        {
            //var part = Partida.PartidakLortu(this.HttpContext);
            Partida langilea = new Partida(puntuazioa, kills, time, date, new Employee(izena,jobTitle,workPhone,workEmail));
            List<Partida> partidak = new List<Partida>();

            partidak.Add(langilea);
            var partidaViewModel = new PartidaViewModel();
            partidaViewModel.partidak =partidak;
           
            return View(partidaViewModel);
        }
        
        
        // GET: HomeController/Details/5
        /*
        public async Task<IActionResult> PartidaBilatu(string name)
        {
            await _partidaService.GetIzena(name);
            return RedirectToAction("index");
        }
        */
    }
}