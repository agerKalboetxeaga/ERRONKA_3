﻿using GodRun_API_el_bueno_.Services;

using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using GodRun_API_el_bueno_.Models;

namespace GodRun_API_el_bueno_.ViewComponents
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