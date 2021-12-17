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

class partida(models.Models):
	_name = "Partidak.partida"
	_description = "partida baten ezaugarriak ezartzen digun modeloa."

	#clave que ve el usuario
	name= fields.Char(string = "Fecha")