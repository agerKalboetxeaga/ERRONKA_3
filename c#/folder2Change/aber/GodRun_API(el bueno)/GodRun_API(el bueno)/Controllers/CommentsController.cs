﻿using GodRun_API_el_bueno_.Models;
using GodRun_API_el_bueno_.Services;
using GodRun_API_el_bueno_.ViewModels;
using GodRun_WebApi.Models;
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
    public class CommentsController : Controller
    {
       
        private readonly GodRunDbContext _context;
        private readonly IComentsService _commentsService;

        public CommentsController(GodRunDbContext context, IComentsService commentsService)
        {
            _context = context;
            _commentsService = commentsService;
        }
        public async Task<IActionResult> Index()
        {
            CommentsViewModel commentsView = new CommentsViewModel();
            commentsView.comments = await _commentsService.KomentarioakIkusi();
            return View(commentsView);
        }
        public async Task<IActionResult> ikusiJokalaria(string jokalaria) 
        {
            CommentsViewModel commentsView = new CommentsViewModel();
            commentsView.comments = await _commentsService.KomentarioakIkusiLangilea(jokalaria);
            
            return View(commentsView);
        }
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Index([Bind("comment,Jokalaria")] Comments comments)
        {
            if (ModelState.IsValid)
            {
                /* Inkesta gorde*/
                comments.username = HttpContext.User.Identity.Name;
                comments.date = DateTime.Now;
                await _commentsService.KomentarioaGehitu(comments);
                return RedirectToPage("Index");
            }
            return View();
        }

    }
}