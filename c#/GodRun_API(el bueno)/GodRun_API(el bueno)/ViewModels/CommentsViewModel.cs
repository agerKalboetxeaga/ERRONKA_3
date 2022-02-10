using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

using GodRun_API_el_bueno_.ViewModels;
using GodRun_API_el_bueno_.Models;

namespace GodRun_API_el_bueno_.ViewModels
{
    /// <summary>
    /// This is the ViewModel used for comments
    /// </summary>
    public class CommentsViewModel
    {
        /// <summary>
        /// A list to contain sent comments
        /// Name of the employee who played the selected matches
        /// </summary>
        public IList<Comments> comments { get; set; }
        public string izena { get; set; }
    }
}
