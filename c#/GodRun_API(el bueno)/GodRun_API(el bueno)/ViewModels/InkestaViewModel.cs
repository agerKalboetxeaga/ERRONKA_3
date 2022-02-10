using GodRun_API_el_bueno_.Models;
using System;
using System.Collections.Generic;
using System.Linq;

using GodRun_API_el_bueno_.ViewModels;
using System.Threading.Tasks;

namespace GodRun_API_el_bueno_.ViewModels
{
    /// <summary>
    /// This is the ViewModel used for Inkestas
    /// </summary>
    public class InkestaViewModel
    {
        /// <summary>
        /// List of Inkestas for the view
        /// </summary>
        public IList<Inkesta> inkestak { get; set; }


    }
}
