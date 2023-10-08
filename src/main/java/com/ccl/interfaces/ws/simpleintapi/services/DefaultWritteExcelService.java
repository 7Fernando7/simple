package com.ccl.interfaces.ws.simpleintapi.services;

import com.ccl.architecture.tracing.services.annotations.Trace;
import com.ccl.interfaces.ws.simpleintapi.constants.HeadersConstants;
import com.ccl.interfaces.ws.simpleintapi.dtos.TestDto;
import com.ccl.interfaces.ws.simpleintapi.dtos.documents.UploadResponse;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class DefaultWritteExcelService {

    private static final String FILE_NAME = "myExcelFile.xlsx";
    private static final String FILE_PATH = "temp/";

    @Resource
    private DocumentsUploadService documentsUploadService;

    //*/10 * * * * *

    @Scheduled(cron = "*/10 * * * * *")
    @Trace(operation = "SIMPLE_GENERATE_EXCEL")
    public void generateExcel() {
        log.info("IN generateExcel");
        List<TestDto> dataList = generateData();
        String[] headersList = {"ID", "NAME", "AGE", "CITY"};

        int indexRow = 0;

        try (Workbook book = new XSSFWorkbook()) {
            Sheet sheet = book.createSheet("Sheet 1");
            sheet.addMergedRegion(CellRangeAddress.valueOf("B1:F1"));
            sheet.addMergedRegion(CellRangeAddress.valueOf("H1:Q1"));

            // write headers WAGON / CONTAINER
            Row rowHeaders = sheet.createRow(indexRow);
            for (int k = 0; k < HeadersConstants.HEADERS_LIST.length; k++) {
                Cell cell = rowHeaders.createCell(k);
                cell.setCellStyle(createHeadersStyle(book));
                cell.setCellValue(HeadersConstants.HEADERS_LIST[k]);
            }

            // write headers TIITLES
            indexRow++;
            Row rowTittles = sheet.createRow(indexRow);
            for (int k = 0; k < HeadersConstants.TITTLES_LIST.length; k++) {
                Cell cell = rowTittles.createCell(k);
                cell.setCellStyle(createHeadersStyle(book));
                cell.setCellValue(HeadersConstants.TITTLES_LIST[k]);
            }

            // write DATA
            indexRow++;
            for (TestDto test : dataList) {
                Row row = sheet.createRow(indexRow);
                writeCellData(test, row, book);
                indexRow++;
            }

            // Crear el fichero
            try (FileOutputStream outputStream = new FileOutputStream(FILE_PATH.concat(FILE_NAME))) {
                book.write(outputStream);
                log.info("Book save OK");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            // generar el array de bytes
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            book.write(bos);
            bos.close();
           // byte[] bytes = bos.toByteArray();

            // subida del documento
            // UploadResponse response = documentsUploadService.uploadDocument(bytes, FILE_NAME);

            // log.info("Upload file OK with ID ---> {} ", response.getId());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeCellData(TestDto test, Row row, Workbook workbook) {
        // Cell cellOrder
        createCell(row, workbook, 0, test.getName());
        // Cell cellConsign
        createCell(row, workbook, 1, test.getName());
        // Cell cellNumWagon
        createCell(row, workbook, 2, test.getName());
        // Cell cellTaraWagon
        createCell(row, workbook, 3, test.getName());
        // Cell cellSealWagon
        createCell(row, workbook, 4, test.getName());
        // Cell cellFmWagon
        createCell(row, workbook, 5, test.getName());
        // Cell cellNumContainer
        createCell(row, workbook, 7, test.getName());
        // Cell cellFootContainer
        createCell(row, workbook, 8, test.getName());
        // Cell cellVcContainer
        createCell(row, workbook, 9, test.getName());
        // Cell cellChargeContainer
        createCell(row, workbook, 10, test.getName());
        // Cell cellHeightContainer
        createCell(row, workbook, 11, test.getName());
        // Cell cellTaraContainer
        createCell(row, workbook, 12, test.getName());
        // Cell cellChargeMaxContainer
        createCell(row, workbook, 13, test.getName());
        // Cell cellDestinationContainer
        createCell(row, workbook, 14, test.getName());
        // Cell cellDateContainer
        createCell(row, workbook, 15, test.getName());
        // Cell cellAteContainer
        createCell(row, workbook, 16, test.getName());
    }

    private void createCell(Row row, Workbook workbook, int indexCell, String data) {
        Cell cell = row.createCell(indexCell);
        cell.setCellStyle(createDataStyle(workbook));
        cell.setCellValue(data);
    }

    private CellStyle createHeadersStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        font.setBold(true);
        style.setFont(font);

        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);

        style.setFillForegroundColor(IndexedColors.AQUA.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        return style;
    }

    private CellStyle createDataStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Calibri");
        style.setFont(font);
        return style;
    }

    private List<TestDto> generateData() {
        List<TestDto> list = new ArrayList<>();
        list.add(TestDto.builder().id(1L).name("Name test 1").age(21).city("City test 1").build());
        list.add(TestDto.builder().id(2L).name("Name test 2").age(22).city("City test 2").build());
        list.add(TestDto.builder().id(3L).name("Name test 3").age(23).city("City test 3").build());
        list.add(TestDto.builder().id(4L).name("Name test 4").age(24).city("City test 4").build());
        list.add(TestDto.builder().id(5L).name("Name test 5").age(25).city("City test 5").build());
        list.add(TestDto.builder().id(6L).name("Name test 6").age(26).city("City test 6").build());
        list.add(TestDto.builder().id(7L).name("Name test 7").age(27).city("City test 7").build());
        return list;
    }
}
