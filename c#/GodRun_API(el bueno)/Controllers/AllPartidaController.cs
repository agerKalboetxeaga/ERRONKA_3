using GodRun_API_el_bueno_.Models;
using GodRun_API_el_bueno_.ViewModels;
using GodRun_API_el_bueno_.Services;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using GodRun_API_el_bueno_.ViewModels;

namespace GodRun_API_el_bueno_.Controllers
{
    public class AllPartidaController : Controller
    {
        private readonly IPartidaService _partidaService;
        public AllPartidaController(IPartidaService _partidaService)
        {
            this._partidaService = _partidaService;
        }

        // GET: HomeController
        public async Task<IActionResult> Index()
        {
            //var part = Partida.PartidakLortu(this.HttpContext);
            var partidaViewModel = new PartidaViewModel();
            partidaViewModel.partidak = await _partidaService.GetPartidas();
            return View(partidaViewModel);
        }
        public async Task<IActionResult> HallOfFame()
        {
            //var part = Partida.PartidakLortu(this.HttpContext);
            var partidaViewModel = new PartidaViewModel();
            List<Partida> partidas = new List<Partida>();
            partidaViewModel.partidak = await _partidaService.GetHoF();

           
            return View(partidaViewModel);
        }
            public async Task<IActionResult> HallOfShame()
        {
            //var part = Partida.PartidakLortu(this.HttpContext);
            var partidaViewModel = new PartidaViewModel();
            List<Partida> partidas = new List<Partida>();
            partidaViewModel.partidak = await _partidaService.GetHoS();

            
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
