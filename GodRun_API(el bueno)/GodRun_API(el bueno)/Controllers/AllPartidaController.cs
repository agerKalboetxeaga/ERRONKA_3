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
    /// <summary>
    /// Controller for Partidas
    /// </summary>
    public class AllPartidaController : Controller
    {
        private readonly IPartidaService _partidaService;
        public AllPartidaController(IPartidaService _partidaService)
        {
            this._partidaService = _partidaService;
        }

        // GET: HomeController
        /// <summary>
        /// This method will return a view containing a List of all partidak
        /// </summary>
        /// <returns>returns a view containing a List of all partidak</returns>
        public async Task<IActionResult> Index()
        {
            //var part = Partida.PartidakLortu(this.HttpContext);
            var partidaViewModel = new PartidaViewModel();
            partidaViewModel.partidak = await _partidaService.GetPartidas();
            return View(partidaViewModel);
        }
         /// <summary>
        /// This method will return a view with a list containing a The 10 best games
        /// </summary>
        /// <returns>returns a view with a list containing a The 10 best games</returns>
        public async Task<IActionResult> HallOfFame()
        {
            //var part = Partida.PartidakLortu(this.HttpContext);
            var partidaViewModel = new PartidaViewModel();
            List<Partida> partidas = new List<Partida>();
            partidaViewModel.partidak = await _partidaService.GetHoF();

           
            return View(partidaViewModel);
        }

        /// <summary>
        /// This method will return a view with a list containing a The 10 worst games
        /// </summary>
        /// <returns>returns a view with a list containing a The 10 worst games</returns>
        public async Task<IActionResult> HallOfShame()
        {
            //var part = Partida.PartidakLortu(this.HttpContext);
            var partidaViewModel = new PartidaViewModel();
            List<Partida> partidas = new List<Partida>();
            partidaViewModel.partidak = await _partidaService.GetHoS();

            
            return View(partidaViewModel);
        }


       
    }
}
