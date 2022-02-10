using GodRun_API_el_bueno_.Models;
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
    /// <summary>
    /// This class is the controller class for comments
    /// </summary>
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
        /// <summary>
        /// This method will return a view containing a list with comments
        /// </summary>
        /// <returns>returns a view containing a list with comments</returns>
        public async Task<IActionResult> Index()
        {
            CommentsViewModel commentsView = new CommentsViewModel();
            commentsView.comments = await _commentsService.KomentarioakIkusi();
            return View(commentsView);
        }
        /// <summary>
        /// This method will return a view containing a list with comments made for the given player
        /// </summary>
        /// <param name="jokalaria"> Name of the player you want to see the comments</param>
        /// <returns>Returns a view with a list with comments made for the given player</returns>
        public async Task<IActionResult> ikusiJokalaria(string jokalaria)
        {
            CommentsViewModel commentsView = new CommentsViewModel();
            commentsView.comments = await _commentsService.KomentarioakIkusiLangilea(jokalaria);

            return View(commentsView);
        }
        /// <summary>
        /// This method will add the sent comment to the database
        /// </summary>
        /// <param name="Comment"></param>
        /// <param name="Jokalaria"></param>
        /// <returns>Returns the view of index</returns>
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Index(string Comment, string Jokalaria)
        {
            Comments comment = new Comments();
            comment.comment = Comment;
            comment.jokalaria = Jokalaria;

            /* Inkesta gorde*/
            comment.username = HttpContext.User.Identity.Name;
            comment.date = DateTime.Now;
            await _commentsService.KomentarioaGehitu(comment);
            return RedirectToAction("Index");


        }

    }
}