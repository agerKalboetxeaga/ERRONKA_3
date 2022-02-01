using GodRun_API_el_bueno_.Services;
using GodRun_WebApi.Services;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace GodRun_WebApi.ViewComponents
{
    public class CommentsViewComponent : ViewComponent

    {
        private readonly IComentsService _comentsService;

        public CommentsViewComponent(IComentsService comentsService)
        {
            _comentsService = comentsService;
        }
        public async Task<IViewComponentResult> InvokeAsync()
        {
            return View();
        }
    }
}
