using GodRun_API_el_bueno_.Models;
using GodRun_API_el_bueno_.Services;
using GodRun_API_el_bueno_.ViewModels;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace GodRun_API_el_bueno_.Controllers
{
    [Authorize]
    public class InkestaController : Controller
    {
        // GET: InkestaController
        private readonly GodRunDbContext _context;
        private readonly IInkestaService _inkestaService;

        public InkestaController(GodRunDbContext context, IInkestaService inkestaService)
        {
            this._context = context;
            this._inkestaService = inkestaService;
        }
        public async Task<IActionResult>Index()
        {
            InkestaViewModel inkestaView = new InkestaViewModel();
            inkestaView.inkestak = await _inkestaService.InkestaIkusi();
            return View(inkestaView);
        }
        public async Task<IActionResult> ikusiUser()
        {
            InkestaViewModel inkestaView = new InkestaViewModel();
            inkestaView.inkestak = await _inkestaService.InkestaIkusiUser(HttpContext.User.Identity.Name);
            return View(inkestaView);
        }
   

        [HttpPost]
            [ValidateAntiForgeryToken]
            public async Task<IActionResult> ShowInkesta([Bind("Galdera1,Galdera2,Galdera3,Galdera4,Galdera5")] Inkesta inkesta)
        {
            if (ModelState.IsValid)
            {
                /* Inkesta gorde*/
                inkesta.Erabiltzailea = HttpContext.User.Identity.Name;
                inkesta.Data = DateTime.Now;
                await _inkestaService.InkestaGehitu(inkesta);
                return View("/Views/Home/Index.cshtml");
            }
            return View();
        }
    }
}
