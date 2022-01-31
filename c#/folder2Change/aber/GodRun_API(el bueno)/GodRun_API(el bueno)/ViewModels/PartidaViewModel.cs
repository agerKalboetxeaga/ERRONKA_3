using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using GodRun_API_el_bueno_.Models;
using GodRun_WebApi.Models;
namespace GodRun_WebApi.ViewModels
{
    public class PartidaViewModel
    {
        public IList<Partida> partidak { get; set; }
        public IList<Employee> employees { get; set; }

    }
}
