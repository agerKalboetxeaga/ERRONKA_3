using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using GodRun_API_el_bueno_.ViewModels;
using GodRun_API_el_bueno_.Models;

namespace GodRun_API_el_bueno_.ViewModels
{
    /// <summary>
    /// View Model for Partida view
    /// </summary>
    public class PartidaViewModel
    {
        /// <summary>
        /// List containing the partidas given, and a List of the employees that played partidas
        /// </summary>
        public IList<Partida> partidak { get; set; }
        public IList<Employee> employees { get; set; }

    }
}
