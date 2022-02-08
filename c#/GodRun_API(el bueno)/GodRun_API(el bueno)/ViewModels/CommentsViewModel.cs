using GodRun_WebApi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

using GodRun_API_el_bueno_.ViewModels;
using GodRun_API_el_bueno_.Models;

namespace GodRun_API_el_bueno_.ViewModels
{
    public class CommentsViewModel
    {
        public IList<Comments> comments { get; set; }
        public string izena { get; set; }
    }
}
