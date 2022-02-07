using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

using GodRun_API_el_bueno_.ViewModels;
using GodRun_API_el_bueno_.Services;

namespace GodRun_WebApi.Controllers
{
    public class PartidaController : Controller
    {
        private readonly IPartidaService _partidaService;
        public PartidaController(IPartidaService _partidaService)
        {
            this._partidaService = _partidaService;
        }

        // GET: HomeController
        public async Task <IActionResult> Index(string langilea)
        {
            //var part = Partida.PartidakLortu(this.HttpContext);
            var partidaViewModel = new PartidaViewModel();
           partidaViewModel.partidak = await _partidaService.GetIzena(langilea);
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
