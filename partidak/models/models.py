# -*- coding: utf-8 -*-

# from odoo import models, fields, api


# class partidak(models.Model):
#     _name = 'partidak.partidak'
#     _description = 'partidak.partidak'

#     name = fields.Char()
#     value = fields.Integer()
#     value2 = fields.Float(compute="_value_pc", store=True)
#     description = fields.Text()
#
#     @api.depends('value')
#     def _value_pc(self):
#         for record in self:
#             record.value2 = float(record.value) / 100

from odoo import models, fields, api

class partida(models.Model):
	_name = "partidak.partida"
	_description = "Partida baten ezaugarriak ezartzen digun modeloa."
	_order = 'puntuazioa'
	#_inherit = 'res.partner'

	#clave que ve el usuario (string='')
	#name= fields.Char(string = "Nombre", required=True,)

	#partner_name = fields.Many2one('res.partner', string='name')
	puntuazioa = fields.Integer(string='Puntuazioa')
	kills = fields.Integer(string='Kills')
	time = fields.Char(string='Run Time')
	date = fields.Datetime(string='Fecha de la azaña')
	res_partner_id = fields.Many2one(comodel_name='hr.employee', string='Employee')
	function = fields.Char(string='Function',related='res_partner_id.department_id.name', store=True, readonly=False)
	#function = fields.related('res_partner_id','function',type='char')
	#function = 'model' : fields.related('res_partner_id', 'function')
	#Relacion entre tablas
	 # puede petar
	
	#Possible future feature...
	#manquismo= fields.Char(string='Eres malo pero...', compute='imBetter')



