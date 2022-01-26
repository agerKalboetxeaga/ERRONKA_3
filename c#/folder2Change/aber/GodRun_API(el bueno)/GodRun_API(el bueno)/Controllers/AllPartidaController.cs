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
