using GodRun_WebApi.Models;
using GodRun_WebApi.Services;
using GodRun_WebApi.ViewModels;
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
         public async Task<IActionResult> Index(Partida langilea)
         {
             //var part = Partida.PartidakLortu(this.HttpContext);
             var partidaViewModel = new PartidaViewModel();
             partidaViewModel.partidak = new List<Partida>();
             partidaViewModel.partidak.Add(langilea);
             return View(partidaViewModel);
         }
        */

        
        public async Task<IActionResult> Index(int puntuazioa, int kills, string time, string date, string izena, string jobTitle, int workPhone, string workEmail)
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
