(ns association.facts-test
  (:require [clojure.test :refer [deftest is]]
            [association.facts :as facts]))

(deftest vnba-has-spec-basis
  (let [sb (facts/spec-basis "vnba")]
    (is (= 2 (count sb)))
    (is (every? #(= "6419" (:association-rule/isic %)) sb))
    (is (every? #(= "VNM" (:association-rule/country %)) sb))))

(deftest unknown-association-has-no-spec-basis
  (is (nil? (facts/spec-basis "ubf")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["vnba" "ubf"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["ubf"] (:missing-associations c)))))

(deftest by-topic-filters
  (is (= 2 (count (facts/by-topic "vnba" :governance))))
  (is (empty? (facts/by-topic "vnba" :labor)))
  (is (empty? (facts/by-topic "ubf" :governance))))
