using GodRun_API_el_bueno_.Services;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace GodRun_API_el_bueno_.ViewComponents
{
    /// <summary>
    /// This is the view component for the component of Wgames 
    /// </summary>
    public class WgamesViewComponent : ViewComponent
    {
        private readonly IPartidaService _partidaService;

        public WgamesViewComponent(IPartidaService partidaService)
        {
            _partidaService = partidaService;
        }
        /// <summary>
        /// This method will return a component containing all partidas
        /// </summary>
        /// <param name="id"></param>
        /// <returns></returns>
        public async Task<IViewComponentResult> InvokeAsync(int id)
        {
            return View(await _partidaService.GetMota(id));
        }
    }
}
