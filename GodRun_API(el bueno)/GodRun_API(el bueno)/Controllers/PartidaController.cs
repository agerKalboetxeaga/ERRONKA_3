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
        /// <summary>
        /// Controller class for Partida made by a certain player
        /// </summary>
        private readonly IPartidaService _partidaService;
        public PartidaController(IPartidaService _partidaService)
        {
            this._partidaService = _partidaService;
        }

        // GET: HomeController
        /// <summary>
        /// This method will return a view containing all partidak made by the given employee
        /// </summary>
        /// <param name="langilea">the mployee to lookup</param>
        /// <returns>Returns a view containing all partidak played by the given employee</returns>
        public async Task <IActionResult> Index(string langilea)
        {
            //var part = Partida.PartidakLortu(this.HttpContext);
            var partidaViewModel = new PartidaViewModel();
           partidaViewModel.partidak = await _partidaService.GetIzena(langilea);
            return View(partidaViewModel);
        }

   
    }
}
