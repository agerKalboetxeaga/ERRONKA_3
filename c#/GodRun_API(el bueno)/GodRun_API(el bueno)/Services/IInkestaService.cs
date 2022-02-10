using GodRun_API_el_bueno_.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;


namespace GodRun_API_el_bueno_.Services
{
    /// <summary>
    /// Interface class for the service of Inkesta
    /// </summary>
    public interface IInkestaService
    {
        Task InkestaGehitu(Inkesta inkesta);
        Task<List<Inkesta>> InkestaIkusi();
        Task<List<Inkesta>> InkestaIkusiUser(string user);

    }
}
