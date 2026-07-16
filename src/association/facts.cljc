(ns association.facts
  "Industry rule/history catalog for the Vietnam Banks Association
  (VNBA) -- a 35th industry-association-level source per
  ADR-2607141700 (cloud-itonami-compliance-fact-federation). The
  SIXTH entry aligned to ISIC 6419 (other monetary intermediation /
  banking), alongside cloud-itonami-assoc-6419-jpn-zenginkyo (Japan),
  -6419-deu-bankenverband (Germany), -6419-fra-fbf (France),
  -6419-aus-aba (Australia), and -6419-are-ubf (UAE) -- the same
  cross-country-same-ISIC pattern already used for ISIC 2910
  (VDA/SMMT). Continues this session's Vietnam research thread
  alongside cloud-itonami-municipality-vnm-hanoi.

  VITAS (the Vietnam Textile and Apparel Association) was attempted
  first this tick, but its official domain (vietnamtextile.org.vn)
  threw a connection-reset error (ECONNRESET) on four separate URLs
  tried -- abandoned outright as whole-domain-unreachable.

  Both entries here instead cite vnba.org.vn's own History page,
  which states directly: 'Vietnam Banks Association (VNBA) was
  established after the Prime Minister's approval on May 14, 1994'
  and 'On August 23, 1994, VNBA was officially launched after its 1st
  Congress'; separately, 'VNBA joined ASEAN Banking Association' on
  '29 September 1995' as its 7th member. The page also names VNBA's
  first President and General Secretary (1994-1998) -- read only to
  confirm the historical timeline, personal names never stored.

  No Wikidata Q-id was found for VNBA specifically -- omitted rather
  than guessed.

  A rule not in this table has NO spec-basis, full stop; extend
  `catalog`, do not invent an id/url.")

(def catalog
  "assoc-slug -> vector of self-regulatory rule entries."
  {"vnba"
   [{:association-rule/id "vnba.founding-1994"
     :association-rule/title "VNBA founding (History)"
     :association-rule/association "vnba"
     :association-rule/isic "6419"
     :association-rule/country "VNM"
     :association-rule/kind :governance-program
     :association-rule/url "https://vnba.org.vn/en/page/history.htm"
     :association-rule/url-provenance :official-vnba-org-vn
     :association-rule/established-date "1994-05-14"
     :association-rule/retrieved-at "2026-07-16"
     :association-rule/topic #{:governance}}
    {:association-rule/id "vnba.asean-banking-association-join-1995"
     :association-rule/title "VNBA joins ASEAN Banking Association as 7th member (History)"
     :association-rule/association "vnba"
     :association-rule/isic "6419"
     :association-rule/country "VNM"
     :association-rule/kind :governance-program
     :association-rule/url "https://vnba.org.vn/en/page/history.htm"
     :association-rule/url-provenance :official-vnba-org-vn
     :association-rule/established-date "1995-09-29"
     :association-rule/retrieved-at "2026-07-16"
     :association-rule/topic #{:governance}}]})

(defn spec-basis [assoc-slug] (get catalog assoc-slug))

(defn coverage
  ([] (coverage (keys catalog)))
  ([slugs]
   (let [have (filter catalog slugs)
         missing (remove catalog slugs)]
     {:requested (count slugs)
      :covered (count have)
      :covered-associations (vec (sort have))
      :missing-associations (vec (sort missing))
      :note (str "cloud-itonami-assoc-6419-vnm-vnba Wave 0 (ADR-2607141700): "
                 (count (get catalog "vnba")) " vnba entries seeded with an "
                 "official vnba.org.vn citation. Extend "
                 "`association.facts/catalog`, never fabricate a rule id/url.")})))

(defn by-topic [assoc-slug topic]
  (filterv #(contains? (:association-rule/topic %) topic) (spec-basis assoc-slug)))
