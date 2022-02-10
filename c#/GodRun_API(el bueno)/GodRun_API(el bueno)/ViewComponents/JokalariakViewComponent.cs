
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using GodRun_API_el_bueno_.Services;

namespace GodRun_WebApi.ViewComponents
{
    /// <summary>
    /// This is the view component for the component of Jokalariak 
    /// </summary>
    public class JokalariakViewComponent : ViewComponent

    {
        private readonly IPartidaService _partidaService;

        public JokalariakViewComponent(IPartidaService partidaService)
        {
            _partidaService = partidaService;
        }

        /// <summary>
        /// This method will return a component containing all partidas form the Rest Service
        /// </summary>
        /// <param name="id"></param>
        /// <returns>returns a component containing all partidas form the Rest Service</returns>
        public async Task<IViewComponentResult> InvokeAsync(int id)
        {
            return View(await _partidaService.GetPartidas());
        }
    }
}
