package ac.mz.gestaodeinformacao;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;

import java.util.ArrayList;
import java.util.List;

class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "dados.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "usuarios";
    private static final String COLUMN_NOME = "nome";
    private static final String COLUMN_IDADE = "idade";
    private static final String COLUMN_GENERO = "genero";
    private static final String COLUMN_PROVINVIA = "provinvia";
    private static final String COLUMN_GRAVIDADE = "gravidade";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_NOME + " TEXT,"
                + COLUMN_IDADE + " INTEGER,"
                + COLUMN_GENERO + " TEXT,"
                + COLUMN_PROVINVIA + " TEXT,"
                + COLUMN_GRAVIDADE + " TEXT"
                + ")";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Caso você faça alguma alteração na estrutura do banco de dados,
        // você pode adicionar o código aqui para atualizar a tabela.
        // Este exemplo é apenas para fins ilustrativos, portanto, não fazemos nada aqui.
    }

    public void inserirUsuario(String nome, int idade, String genero, String provinvia, String gravidade) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NOME, nome);
        values.put(COLUMN_IDADE, idade);
        values.put(COLUMN_GENERO, genero);
        values.put(COLUMN_PROVINVIA, provinvia);
        values.put(COLUMN_GRAVIDADE, gravidade);

        db.insert(TABLE_NAME, null, values);

        db.close();
    }

    @SuppressLint("Range")
    public List<Dados> listarDados() {
        List<Dados> listaDados = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Dados dados = new Dados();
                dados.setNome(cursor.getString(cursor.getColumnIndex(COLUMN_NOME)));
                dados.setIdade(cursor.getInt(cursor.getColumnIndex(COLUMN_IDADE)));
                dados.setGenero(cursor.getString(cursor.getColumnIndex(COLUMN_GENERO)));
                dados.setProvinvia(cursor.getString(cursor.getColumnIndex(COLUMN_PROVINVIA)));
                dados.setGravidade(cursor.getString(cursor.getColumnIndex(COLUMN_GRAVIDADE)));

                listaDados.add(dados);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();



        return listaDados;
    }

    public ArrayList<Dados> getAllDados() {
        List<Dados> listaDados = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") String nome = cursor.getString(cursor.getColumnIndex(COLUMN_NOME));
                @SuppressLint("Range") int idade = cursor.getInt(cursor.getColumnIndex(COLUMN_IDADE));
                @SuppressLint("Range") String genero = cursor.getString(cursor.getColumnIndex(COLUMN_GENERO));
                @SuppressLint("Range") String provinvia = cursor.getString(cursor.getColumnIndex(COLUMN_PROVINVIA));
                @SuppressLint("Range") String gravidade = cursor.getString(cursor.getColumnIndex(COLUMN_GRAVIDADE));

                Dados dados = new Dados(nome, idade, genero, provinvia, gravidade);
                listaDados.add(dados);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return (ArrayList<Dados>) listaDados;
    }

    @SuppressLint("Range")
    public List<Dados> listarDadosMasculinos() {
        List<Dados> listaDadosMasculinos = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_GENERO + " = 'Masculino'";
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Dados dados = new Dados();
                dados.setNome(cursor.getString(cursor.getColumnIndex(COLUMN_NOME)));
                dados.setIdade(cursor.getInt(cursor.getColumnIndex(COLUMN_IDADE)));
                dados.setGenero(cursor.getString(cursor.getColumnIndex(COLUMN_GENERO)));
                dados.setProvinvia(cursor.getString(cursor.getColumnIndex(COLUMN_PROVINVIA)));
                dados.setGravidade(cursor.getString(cursor.getColumnIndex(COLUMN_GRAVIDADE)));

                listaDadosMasculinos.add(dados);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return listaDadosMasculinos;
    }

    @SuppressLint("Range")
    public List<Dados> listarDadosFemininos() {
        List<Dados> listaDadosFemininos = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_GENERO + " = 'Feminino'";
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Dados dados = new Dados();
                dados.setNome(cursor.getString(cursor.getColumnIndex(COLUMN_NOME)));
                dados.setIdade(cursor.getInt(cursor.getColumnIndex(COLUMN_IDADE)));
                dados.setGenero(cursor.getString(cursor.getColumnIndex(COLUMN_GENERO)));
                dados.setProvinvia(cursor.getString(cursor.getColumnIndex(COLUMN_PROVINVIA)));
                dados.setGravidade(cursor.getString(cursor.getColumnIndex(COLUMN_GRAVIDADE)));

                listaDadosFemininos.add(dados);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return listaDadosFemininos;
    }





}

