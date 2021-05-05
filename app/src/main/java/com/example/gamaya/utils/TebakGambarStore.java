package com.example.gamaya.utils;

import com.example.gamaya.R;

public class TebakGambarStore {

    private static final String[] questions = {
            "Yang manakah rumah adat daerah Aceh? ",
            "Yang manakah rumah adat daerah Sumatra Barat?",
            "Yang manakah rumah adat daerah Jawa Tengah?",
            "Yang manakah rumah adat daerah Kalimantan Barat?",
            "Yang manakah rumah adat daerah Maluku?",
            "Yang manakah pakaian adat daerah Sumatra Utara?",
            "Yang manakah pakaian adat daerah Jawa Barat?",
            "Yang manakah pakaian adat daerah Kalimantan Barat?",
            "Yang manakah pakaian adat daerah Bali?",
            "Yang manakah pakaian adat daerah Papua?",
            "Yang manakah tarian adat daerah Aceh?",
            "Yang manakah tarian adat daerah Sumatra Barat?",
            "Yang manakah tarian adat daerah Jawa Barat?",
            "Yang manakah tarian adat daerah Bali?",
            "Yang manakah tarian adat daerah Jawa Tengah?",
            "Yang manakah alat musik daerah Sumatra Barat?",
            "Yang manakah alat musik daerah Jawa Barat?",
            "Yang manakah alat musik daerah Bali?",
            "Yang manakah alat musik daerah Sulawesi Utara?",
            "Yang manakah alat musik daerah Sulawesi Barat?",
    };

    private static final int[][] choices = {
            {R.drawable.rumah_limas, R.drawable.rumah_krong_bade, R.drawable.rumah_tongkonan},
            {R.drawable.rumah_tambi, R.drawable.rumah_lamin, R.drawable.rumah_gadang},
            {R.drawable.rumah_joglo, R.drawable.rumah_bubungan_tinggi, R.drawable.rumah_adat_buton},
            {R.drawable.rumah_kebaya, R.drawable.rumah_adat_selaso_jatuh_kembar, R.drawable.rumah_panjang},
            {R.drawable.rumah_adat_musalaki, R.drawable.rumah_baileo, R.drawable.rumah_honai},
            {R.drawable.pakaian_ulos, R.drawable.pakaian_ulee_balang, R.drawable.pakaian_bundo_kanduang},
            {R.drawable.pakaian_paksian, R.drawable.pakaian_melayu, R.drawable.pakaian_kebaya},
            {R.drawable.pakaian_bodo, R.drawable.pakaian_perang, R.drawable.pakaian_pesaan},
            {R.drawable.pakaian_payas_agung, R.drawable.pakaian_nggembe, R.drawable.pakaian_cele},
            {R.drawable.pakaian_ulos, R.drawable.pakaian_perang, R.drawable.pakaian_koteka},
            {R.drawable.tari_saman_mausekat, R.drawable.tari_makan_sirih, R.drawable.tari_tortor},
            {R.drawable.tari_selampit_delapan, R.drawable.tari_topeng, R.drawable.tari_piring},
            {R.drawable.tari_kipas, R.drawable.tari_jaipong, R.drawable.tari_tanggai},
            {R.drawable.tari_kecak, R.drawable.tari_monong, R.drawable.tari_baksa_kembang},
            {R.drawable.tari_piring, R.drawable.tari_lumense, R.drawable.tari_gambyong},
            {R.drawable.alat_musik_serune_kale, R.drawable.alat_musik_burdah, R.drawable.alat_musik_saluang},
            {R.drawable.alat_musik_gambus, R.drawable.alat_musik_aramba, R.drawable.alat_musik_angklung},
            {R.drawable.alat_musik_cengceng, R.drawable.alat_musik_sampe, R.drawable.alat_musik_tehyan},
            {R.drawable.alat_musik_gamelan, R.drawable.alat_musik_kolintang, R.drawable.alat_musik_sasando},
            {R.drawable.alat_musik_kecapi, R.drawable.alat_musik_serunai, R.drawable.alat_musik_tifa},
    };

    private static final int[] correctAnswer = {
            1,2,0,2,1,
            0,2,1,0,2,
            0,2,1,0,2,
            2,2,0,1,0,
    };

    public static int[] getChoices(int positiong) {
        return choices[positiong];
    }

    public static int getCorrectAnswer(int positiong) {
        return correctAnswer[positiong];
    }

    public static String getQuestions(int positiong) {
        return questions[positiong];
    }

    public static String[] getQuestions() {
        return questions;
    }
}
