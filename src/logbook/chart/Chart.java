
package logbook.chart;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;




public class Chart extends javax.swing.JPanel {

    private List<ModelLegend> legends=new ArrayList<>();
    private List<ModelChart> model = new ArrayList<>();
    private final int seriesSpace = 6;
    private final int seriesSize = 12;
    private final Animator animator;
    private float animate;
    
    public Chart() {
        initComponents();
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                animate = fraction;
                repaint();
            }
            
        };
        animator=new Animator(800, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        
        blankPlotChart.setBlankPlotChatRender(new BlankPlotChatRender() {
            @Override
            public String getLabelText(int index) {
                return model.get(index).getLabel();
            }

            @Override
            public void renderSeries(BlankPlotChart chart, Graphics2D g2, SeriesSize size, int index) {
                double totalSeriesWidth = (seriesSize * legends.size()) + (seriesSpace * (legends.size() - 1));
                double x = (size.getWidth() - totalSeriesWidth) / 2;
                for (int i = 0; i < legends.size(); i++) {
                    ModelLegend legend = legends.get(i);
                    g2.setColor(legend.getColor());
                    double seriesValues = chart.getSeriesValuesOf(model.get(index).getValues()[i], size.getHeight()) * animate;
                    g2.fillRect((int) (size.getX() + x), (int) (size.getY() + size.getHeight() - seriesValues), seriesSize, (int) seriesValues);
                    x += seriesSpace + seriesSize;
                }
            }
        });
        }

    public void addLegend(String name, Color color) {
        ModelLegend data = new ModelLegend(name, color);
        legends.add(data);
        panelLegend.add(new LegendItem(data));
        panelLegend.repaint();
        panelLegend.revalidate();
    }
    public void addData(ModelChart data) {
        model.add(data);
        blankPlotChart.setLabelCount(model.size());
        double max = data.getMaxValues();
        if (max > blankPlotChart.getMaxValues()) {
            blankPlotChart.setMaxValues(max);
        }
    }
    
    public void start() {
        if (!animator.isRunning()) {
            animator.start();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        blankPlotChart1 = new logbook.chart.BlankPlotChart();
        blankPlotChart2 = new logbook.chart.BlankPlotChart();
        blankPlotChart3 = new logbook.chart.BlankPlotChart();
        blankPlotChart4 = new logbook.chart.BlankPlotChart();
        blankPlotChart5 = new logbook.chart.BlankPlotChart();
        blankPlotChart6 = new logbook.chart.BlankPlotChart();
        blankPlotChart7 = new logbook.chart.BlankPlotChart();
        blankPlotChart8 = new logbook.chart.BlankPlotChart();
        blankPlotChart9 = new logbook.chart.BlankPlotChart();
        blankPlotChart10 = new logbook.chart.BlankPlotChart();
        blankPlotChart = new logbook.chart.BlankPlotChart();
        panelLegend = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setAutoscrolls(true);

        panelLegend.setOpaque(false);
        panelLegend.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelLegend, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(blankPlotChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(blankPlotChart, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelLegend, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private logbook.chart.BlankPlotChart blankPlotChart;
    private logbook.chart.BlankPlotChart blankPlotChart1;
    private logbook.chart.BlankPlotChart blankPlotChart10;
    private logbook.chart.BlankPlotChart blankPlotChart2;
    private logbook.chart.BlankPlotChart blankPlotChart3;
    private logbook.chart.BlankPlotChart blankPlotChart4;
    private logbook.chart.BlankPlotChart blankPlotChart5;
    private logbook.chart.BlankPlotChart blankPlotChart6;
    private logbook.chart.BlankPlotChart blankPlotChart7;
    private logbook.chart.BlankPlotChart blankPlotChart8;
    private logbook.chart.BlankPlotChart blankPlotChart9;
    private javax.swing.JPanel panelLegend;
    // End of variables declaration//GEN-END:variables

    public void add(String testoig) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
