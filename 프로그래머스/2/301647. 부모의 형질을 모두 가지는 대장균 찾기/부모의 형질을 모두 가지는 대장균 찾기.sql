SELECT
    sub.ID,
    sub.GENOTYPE,
    m.GENOTYPE AS PARENT_GENOTYPE
FROM
    ECOLI_DATA sub
        JOIN ECOLI_DATA m ON sub.PARENT_ID = m.ID
WHERE
    (sub.GENOTYPE & m.GENOTYPE) = m.GENOTYPE
ORDER BY
    1