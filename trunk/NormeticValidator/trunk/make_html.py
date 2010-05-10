from lxml.etree import XSLT, parse
from urllib2 import urlopen

files = {
'1.7': 'LOMv1.0_element_1_7_structure_voc.xml',
'1.8': 'LOMv1.0_element_1_8_aggregation_level_voc.xml',
'2.2': 'LOMv1.0_element_2_2_status_voc.xml', # Not used yet
'2.3.1': 'LOMv1.0_element_2_3_1_role_voc.xml',
'3.2.1': 'LOMv1.0_element_3_2_1_role_voc.xml',
'4.4.1.1': 'LOMv1.0_element_4_4_1_1_type_voc.xml',
'4.4.1.2': 'LOMv1.0_element_4_4_1_2_type_browser_voc.xml',
'4.4.1.2b': 'LOMv1.0_element_4_4_1_2_type_operating_system_voc.xml', # Append by hand to previous file
'5.1': 'LOMv1.0_element_5_1_interactivity_type_voc.xml',
'5.2': 'typeressourcev1_2.xml',
'5.3': 'LOMv1.0_element_5_3_interactivity_level_voc.xml',
'5.4': 'LOMv1.0_element_5_4_semantic_density_voc.xml',
'5.5': 'LOMv1.0_element_5_5_intended_end_user_role_voc.xml',
'5.6': 'NORMETICv1.2_element_5_6_contexte_voc.xml',
'5.8': 'LOMv1.0_element_5_8_difficulty_voc.xml',
'6.1': 'LOMv1.0_common_yes_no_voc.xml',
'6.2': 'NORMETICv1.0_element_6_2_copyright_et_autres_restrictions_voc.xml',
'7.1': 'LOMv1.0_element_7_1_kind_voc.xml',
'9.1': 'LOMv1.0_element_9_1_purpose_voc.xml',
}

vocabularies = {
'5.2': 'http://www.normetic.org/vdex/typeressourcev1_2.xml',
'5.6': 'http://eureka.ntic.org/vdex/NORMETICv1.2_element_5_6_contexte_voc.xml',
'6.2': 'http://eureka.ntic.org/vdex/NORMETICv1.0_element_6_2_copyright_et_autres_restrictions_voc.xml',
}

useLocal = False
localFiles = 'file:web/vocab/xml/'
eureka = 'http://eureka.ntic.org/vdex/'

xsl=XSLT(parse('describe_vcard.xslt'))

for (fieldnum, filename) in files.items():
    source = vocabularies.get(fieldnum, '')
    if useLocal:
        url = localFiles + filename
    else:
        url = eureka+filename
        if source:
            url = source
    xml = parse(urlopen(url))
    for lang in ('en', 'fr'):
        args = {'voc_source':source,'lang':lang,'fieldnum':fieldnum}
        args = dict((k,"'%s'"%(v,)) for (k,v) in args.items())
        with open('web/vocab/%s/LOM_%s.html'%(lang, fieldnum),'w') as html:
            xsl(xml, **args).write(html, encoding='utf-8', method='html', pretty_print=True)
