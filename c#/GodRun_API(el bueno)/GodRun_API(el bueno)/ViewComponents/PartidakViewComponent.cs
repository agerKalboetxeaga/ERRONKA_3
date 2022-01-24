using GodRun_WebApi.Services;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace GodRun_WebApi.ViewComponents
{
    public class PartidakViewComponent : ViewComponent
    {
        private readonly IPartidaService _partidaService;

        public PartidakViewComponent(IPartidaService partidaService)
        { 
            _partidaService = partidaService;
        }
        public async Task<IViewComponentResult> InvokeAsync(int id)
        {
            return View(await _partidaService.GetMota(id));
        }

    }
}
