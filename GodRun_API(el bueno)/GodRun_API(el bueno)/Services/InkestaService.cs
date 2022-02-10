using GodRun_API_el_bueno_.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;


namespace GodRun_API_el_bueno_.Services
{
    /// <summary>
    /// Implementation class of IInkestaService
    /// </summary>
    public class InkestaService : IInkestaService
    {
        private readonly GodRunDbContext _context;

        public InkestaService(GodRunDbContext context)
        {
            _context = context;
        }

        /// <summary>
        /// This method will add the sent inkesta into the Database
        /// </summary>
        /// <param name="inkesta">Inkesta to upload</param>
        /// <returns></returns>
        public async Task InkestaGehitu(Inkesta inkesta)
        {
            _context.Inkesta.Add(inkesta);
            _context.SaveChanges();
        }

        /// <summary>
        /// This method will allow to see all inkestas made (for admin purpose)
        /// </summary>
        /// <returns></returns>
        public async Task<List<Inkesta>> InkestaIkusi()
        {
            return _context.Inkesta.ToList();
        }

        /// <summary>
        /// This method will allow to see all inkestas made by the sent employee 
        /// </summary>
        /// <param name="user">name of employee</param>
        /// <returns></returns>
        public async Task<List<Inkesta>> InkestaIkusiUser(string user)
        {
            return _context.Inkesta.Where(i => i.Erabiltzailea == user).ToList();
        }
    
    }
}
