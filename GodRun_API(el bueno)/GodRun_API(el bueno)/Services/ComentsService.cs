using GodRun_API_el_bueno_.Models;

using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace GodRun_API_el_bueno_.Services
{
    /// <summary>
    /// Implementation class of ICommentsService
    /// </summary>
    public class ComentsService : IComentsService
    {
        private readonly GodRunDbContext _context;

        public ComentsService(GodRunDbContext context)
        {
            _context = context;
        }
        /// <summary>
        /// This method adds the sent comment to GodRun DB
        /// </summary>
        /// <param name="comment">The comment to upload</param>
        /// <returns></returns>
        public async Task KomentarioaGehitu(Comments comment)
        {
            _context.Comments.Add(comment);
            _context.SaveChanges();
        }

        /// <summary>
        /// This method will allow to see all comments made (for admin purpose)
        /// </summary>
        /// <returns></returns>
        public async Task<List<Comments>> KomentarioakIkusi() //awaits quitaus y el Ienumerable quitau taen
        {
            return _context.Comments.ToList();
        }

        /// <summary>
        /// This method will allow to see all comments made by the sent employee 
        /// </summary>
        /// <param name="jokalaria">name of employee</param>
        /// <returns></returns>
        public async Task<List<Comments>> KomentarioakIkusiLangilea(string jokalaria)
        {
            return _context.Comments.Where(c => c.jokalaria == jokalaria).ToList();
        }

        
    }
}
