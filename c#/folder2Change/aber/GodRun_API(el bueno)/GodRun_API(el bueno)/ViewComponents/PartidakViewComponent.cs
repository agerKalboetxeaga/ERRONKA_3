using GodRun_WebApi.Models;
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
            IList<Partida> partidak = await _partidaService.GetMota(id);
            List<Partida> partidakClean = partidak.ToList();
            List<String> names = new List<String>();
            foreach(Partida p in partidakClean){
                if (!names.Contains(p.employee.name))
                {
                    names.Add(p.employee.name);
                }
                else
                {
                    partidak.Remove(p);
                }
                
            }
            return View(partidak);
        }

    }
}
